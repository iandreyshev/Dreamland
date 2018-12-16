using Dreamland.Domain;

namespace Dreamland.UseCase.Dreams
{
	public class SaveUseCase
	{
		public Result Execute(string id, string password, DreamProperties properties)
		{
			throw new System.NotImplementedException();
		}

		public class Result
		{
			public enum Error
			{
				USER_NOT_EXISTS,
				UNDEFINED
			};

			public long dreamId;
			public Error? error;
		}
	}
}
