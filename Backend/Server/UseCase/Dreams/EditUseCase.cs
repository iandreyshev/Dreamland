using Dreamland.Domain;

namespace Dreamland.UseCase.Dreams
{
	public class EditUseCase
	{
		public Result Execute(string id, string password, DreamProperties properties)
		{
			throw new System.NotImplementedException();
		}

		public enum Result
		{
			SUCCESS,
			ERROR_USER_NOT_EXISTS,
			ERROR_UNDEFINED
		};
	}
}
