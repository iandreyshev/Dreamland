namespace Dreamland.UseCase.Account
{
	public class DeleteAccountUseCase
	{
		public Result Execute(int id, string password)
		{
			throw new System.NotImplementedException();
		}

		public class Result
		{
			public enum Error
			{
				NOT_EXISTS,
				UNDEFINED
			}

			public Result(Error error)
			{
				this.error = error;
			}

			public Error error;
		}
	}
}