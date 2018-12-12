using Dreamland.Domain;

namespace Dreamland.UseCase.Account
{
    public class SignUpUseCase
    {
		public Result Execute(string email, string password, string name)
		{
			throw new System.NotImplementedException();
		}

		public class Result
		{
			public enum Error
			{
				INCORRECT_DATA,
				ALREADY_EXISTS,
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
