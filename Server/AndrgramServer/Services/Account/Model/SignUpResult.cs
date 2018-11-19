using Dreamland.Storage.Account;

namespace Dreamland.Services.Account.Model
{
	public class SignUpResult
	{
		public enum Error
		{
			INCORRECT_DATA,
			ALREADY_EXISTS,
			UNDEFINED
		}

		public SignUpResult(UserEntity user)
		{
			this.user = user;
			error = Error.UNDEFINED;
		}

		public SignUpResult(Error error)
		{
			user = null;
			this.error = error;
		}

		public UserEntity user;
		public Error error;
	}
}
