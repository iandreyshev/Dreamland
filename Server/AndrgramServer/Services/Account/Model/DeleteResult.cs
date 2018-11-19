namespace Dreamland.Services.Account.Model
{
	public class DeleteResult
	{
		public enum Error
		{
			NOT_EXISTS,
			UNDEFINED
		}

		public DeleteResult(Error error)
		{
			this.error = error;
		}

		public Error error;
	}
}
