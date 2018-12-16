using Dreamland.Controllers.Account.Response;
using Dreamland.Domain;
using Dreamland.UseCase.Account;

namespace Dreamland.Controllers.Account.Mapper
{
	public class AccountMapper
	{
		public static SignInResponse Map(SignInUseCase.Result result)
		{
			AccountResponse account = null;
			string error = null;

			switch (result.error)
			{
				case SignInUseCase.Result.Error.NOT_EXISTS:
					error = "0";
					break;
				case null:
					account = Map(result.user);
					break;
			}

			return new SignInResponse
			{
				Account = account,
				Error = error
			};
		}

		public static SignUpResponse Map(SignUpUseCase.Result result)
		{
			AccountResponse account = null;
			string error = null;

			switch (result.error)
			{
				case SignUpUseCase.Result.Error.ALREADY_EXISTS:
					error = "0";
					break;
				case SignUpUseCase.Result.Error.INCORRECT_DATA:
					error = "1";
					break;
				case SignUpUseCase.Result.Error.UNDEFINED:
					account = Map(result.user);
					break;
			}

			return new SignUpResponse
			{
				Account = account,
				Error = error
			};
		}

		public static DeleteResponse Map(DeleteAccountUseCase.Result result)
		{
			string error = null;

			switch (result)
			{
				case DeleteAccountUseCase.Result.SUCCESS:
					break;
				case DeleteAccountUseCase.Result.ERROR_INCORRECT_DATA:
					error = "0";
					break;
				case DeleteAccountUseCase.Result.ERROR_UNDEFINED:
					error = "1";
					break;
			}

			return new DeleteResponse
			{
				Error = error
			};
		}

		private static AccountResponse Map(User account)
		{
			if (account == null)
			{
				return null;
			}

			return new AccountResponse
			{
				Id = account.Id,
				Name = account.Name,
				AvatarUrl = account.AvatarUrl
			};
		}
	}
}
