namespace Dreamland.UseCase.Dreams
{
	public class DeleteDreamUseCase
	{
		public Result Execute(string userId, string userPassword, long dreamId)
		{
			throw new System.NotImplementedException();
		}

		public enum Result
		{
			SUCCESS,
			ERROR_USER_NOT_FOUND
		}
	}
}
