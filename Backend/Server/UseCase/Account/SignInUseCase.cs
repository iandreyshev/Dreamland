using Dreamland.Domain;
using Dreamland.Conditions;
using Dreamland.Storage.Account;

namespace Dreamland.UseCase.Account
{
	public class SignInUseCase
	{
		private IAccountStorage _storage;

		public SignInUseCase(IAccountStorage accountStorage)
		{
			_storage = accountStorage;
		}

		public Result Execute(string email, string password)
		{
			var user = _storage.Find(email, password);

			if (user == null)
			{
				return new Result(Result.Error.NOT_EXISTS);
			}

			return new Result(user);
		}

		public class Result
		{
			public enum Error
			{
				NOT_EXISTS,
				UNDEFINED
			}

			public Result(User user)
			{
				this.user = user;
				error = Error.UNDEFINED;
			}

			public Result(Error error)
			{
				user = null;
				this.error = error;
			}

			public User user;
			public Error error;
		}
	}
}
