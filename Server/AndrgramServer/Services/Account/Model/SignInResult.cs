using Dreamland.Storage.Account;

namespace Dreamland.Services.Account.Model
{
	public class SignInResult
	{
		public enum Error
		{
			INCORRECT_DATA,
			NOT_EXISTS,
			UNDEFINED
		}

		public SignInResult(UserEntity user)
		{
			this.user = user;
			error = Error.UNDEFINED;
		}

		public SignInResult(Error error)
		{
			user = null;
			this.error = error;
		}

		public UserEntity user;
		public Error error;
	}
}