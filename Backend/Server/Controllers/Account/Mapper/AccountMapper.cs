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
				case SignInUseCase.Result.Error.UNDEFINED:
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

			switch (result.error)
			{
				case DeleteAccountUseCase.Result.Error.NOT_EXISTS:
					error = "0";
					break;
				case DeleteAccountUseCase.Result.Error.UNDEFINED:
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
