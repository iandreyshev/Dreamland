using Dreamland.Conditions;
using Dreamland.Domain;
using Dreamland.Storage.Account;

namespace Dreamland.UseCase.Account
{
    public class SignUpUseCase
	{
		private IAccountStorage _storage;

		public SignUpUseCase(IAccountStorage accountStorage)
		{
			_storage = accountStorage;
		}

		public Result Execute(string email, string password, string name)
		{
			if (!Condition.IsValidEmail(email))
			{
				return Result.IncorrectData();
			}
			if (!Condition.IsValidName(name))
			{
				return Result.IncorrectData();
			}
			if (!Condition.IsValidPassword(password))
			{
				return Result.IncorrectData();
			}

			return _storage.Transaction(Result.Undefined(), _ =>
			{
				var user = _storage.Find(email, password);

				if (user != null)
				{
					return Result.AlreadyExists();
				}

				_storage.Add(new User
				{
					Email = email,
					Password = password,
					Name = name
				});

				return new Result { user = _storage.Find(email, password) };
			});
		}

		public class Result
		{
			public static Result IncorrectData()
			{
				return new Result { error = Error.INCORRECT_DATA };
			}

			public static Result AlreadyExists()
			{
				return new Result { error = Error.ALREADY_EXISTS };
			}

			public static Result Undefined()
			{
				return new Result { error = Error.UNDEFINED };
			}

			public enum Error
			{
				INCORRECT_DATA,
				ALREADY_EXISTS,
				UNDEFINED
			}

			public User user;
			public Error? error = null;
		}
	}
}
