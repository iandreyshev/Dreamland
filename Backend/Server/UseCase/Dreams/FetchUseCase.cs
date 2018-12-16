using Dreamland.Domain;
using Microsoft.AspNetCore.Server.Kestrel.Internal.System.Collections.Sequences;

namespace Dreamland.UseCase.Dreams
{
	public class FetchUseCase
	{
		public Result Execute(string id, string password)
		{

			throw new System.NotImplementedException();
		}

		public class Result
		{
			public enum Error
			{
				USER_NOT_EXISTS,
				UNDEFINED
			}

			public Result(Error error)
			{
				this.error = error;
			}

			public ArrayList<Dream> Dreams { get; set; }
			public Error error;
		}
	}
}
