using Dreamland.Services.Account.Model;
using Dreamland.Storage.Account;

namespace Dreamland.Services.Account
{
	public class AccountService : IAccountService
	{
		private AccountStorage _storage = new AccountStorage();

		public SignInResult SignIn(string email, string password)
		{
			if (!Preconditions.IsValidEmail(email))
			{
				return new SignInResult(SignInResult.Error.INCORRECT_DATA);
			}
			else if (!Preconditions.IsValidPassword(password))
			{
				return new SignInResult(SignInResult.Error.INCORRECT_DATA);
			}

			var entity = _storage.Find(email, password);

			if (entity == null)
			{
				return new SignInResult(SignInResult.Error.NOT_EXISTS);
			}

			return new SignInResult(entity);
		}

		public SignUpResult SignUp(string email, string password, string name)
		{
			if (!Preconditions.IsValidEmail(email))
			{
				return new SignUpResult(SignUpResult.Error.INCORRECT_DATA);
			}
			else if (!Preconditions.IsValidPassword(password))
			{
				return new SignUpResult(SignUpResult.Error.INCORRECT_DATA);
			}
			else if (!Preconditions.IsValidName(name))
			{
				return new SignUpResult(SignUpResult.Error.INCORRECT_DATA);
			}

			var entity = _storage.Add(email, password, name);

			if (entity == null)
			{
				return new SignUpResult(SignUpResult.Error.ALREADY_EXISTS);
			}

			return new SignUpResult(entity);
		}

		public DeleteResult Delete(int id, string password)
		{
			var isDeleted = _storage.Delete(id, password);

			if (!isDeleted)
			{
				return new DeleteResult(DeleteResult.Error.NOT_EXISTS);
			}

			return new DeleteResult(DeleteResult.Error.UNDEFINED);
		}
	}
}
