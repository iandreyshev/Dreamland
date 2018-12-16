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
			public enum ErrorCore
			{
				SUCCESS,
				ERROR_USER_NOT_EXISTS
			};

			public long DreamId { get; set; }
			public ErrorCore Error { get; set; }
		}
	}
}
