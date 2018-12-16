using Dreamland.Conditions;
using Dreamland.Domain;
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
				return new Result
				{
					error = Result.Error.NOT_EXISTS
				};
			}

			return new Result
			{
				user = user
			};
		}

		public class Result
		{
			public enum Error
			{
				NOT_EXISTS
			}

			public User user;
			public Error? error = null;
		}
	}
}
