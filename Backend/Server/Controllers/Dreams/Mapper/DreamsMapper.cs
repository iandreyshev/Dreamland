using Dreamland.Controllers.Dreams.Request;
using Dreamland.Controllers.Dreams.Response;
using Dreamland.Domain;
using Dreamland.UseCase.Dreams;
using System.Collections.Generic;

namespace Dreamland.Controllers.Dreams.Mapper
{
	public class DreamsMapper
	{
		public static FetchResponse Map(FetchUseCase.Result result)
		{
			List<Dream> dreams = null;
			string error = null;

			switch (result.error)
			{
				case null:
					dreams = result.dreams;
					break;
				case FetchUseCase.Result.Error.USER_NOT_EXISTS:
					error = "user_not_exists";
					break;
				case FetchUseCase.Result.Error.UNDEFINED:
					error = "undefined";
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

			switch (result.error)
			{
				case null:
					dreamId = result.dreamId;
					break;
				case SaveUseCase.Result.Error.USER_NOT_EXISTS:
					error = "user_not_exists";
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
					error = "user_not_exists";
					break;
				case EditUseCase.Result.ERROR_UNDEFINED:
					error = "undefined";
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
				case DeleteDreamUseCase.Result.ERROR_USER_NOT_EXISTS:
					error = "user_not_exists";
					break;
				case DeleteDreamUseCase.Result.ERROR_UNDEFINED:
					error = "undefined";
					break;
			}

			return new DeleteResponse
			{
				Error = error
			};
		}

		public static DreamProperties Map(RequestDream properties)
		{
			return new DreamProperties
			{
				Description = properties.Description,
				IsLucid = properties.IsLucid,
				SleepingDate = properties.SleepingDate
			};
		}
	}
}
