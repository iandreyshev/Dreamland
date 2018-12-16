using Dreamland.Controllers.Dreams.Response;
using Dreamland.Domain;
using Dreamland.UseCase.Dreams;
using Microsoft.AspNetCore.Server.Kestrel.Internal.System.Collections.Sequences;

namespace Dreamland.Controllers.Dreams.Mapper
{
	public class DreamsMapper
	{
		public static FetchResponse Map(FetchUseCase.Result result)
		{
			ArrayList<Dream> dreams = new ArrayList<Dream>();
			string error = null;

			switch (result.error)
			{
				case FetchUseCase.Result.Error.USER_NOT_EXISTS:
					error = "0";
					break;
				case FetchUseCase.Result.Error.UNDEFINED:
					dreams = result.Dreams;
					break;
			}

			return new FetchResponse
			{
				Dreams = dreams,
				Error = error
			};
		}

		public static SaveResponse Map(SaveUseCase.Result result)
		{
			long? dreamId = null;
			string error = null;

			switch (result.Error)
			{
				case SaveUseCase.Result.ErrorCore.SUCCESS:
					dreamId = result.DreamId;
					break;
				case SaveUseCase.Result.ErrorCore.ERROR_USER_NOT_EXISTS:
					error = "0";
					break;
			}

			return new SaveResponse
			{
				DreamId = dreamId,
				Error = error
			};
		}

		public static EditReponse Map(EditUseCase.Result result)
		{
			string error = null;

			switch (result)
			{
				case EditUseCase.Result.SUCCESS:
					break;
				case EditUseCase.Result.ERROR_USER_NOT_EXISTS:
					error = "0";
					break;
			}

			return new EditReponse
			{
				Error = error
			};
		}

		public static DeleteResponse Map(DeleteDreamUseCase.Result result)
		{
			string error = null;

			switch (result)
			{
				case DeleteDreamUseCase.Result.SUCCESS:
					break;
				case DeleteDreamUseCase.Result.ERROR_USER_NOT_FOUND:
					error = "0";
					break;
			}

			return new DeleteResponse
			{
				Error = error
			};
		}
	}
}
