using Dreamland.Services.Account.Model;
using Dreamland.Storage.Account;
using Microsoft.AspNetCore.Mvc;

namespace Dreamland.Controllers.Account.Mapper
{
	public class AccountMapper
	{
		public static SignInResponse Map(Services.Account.Model.SignInResult result)
		{
			AccountResponse account = null;
			string error = null;

			switch (result.error)
			{
				case Services.Account.Model.SignInResult.Error.NOT_EXISTS:
					error = "0";
					break;
				case Services.Account.Model.SignInResult.Error.INCORRECT_DATA:
					error = "1";
					break;
				case Services.Account.Model.SignInResult.Error.UNDEFINED:
					account = Map(result.user);
					break;
			}

			return new SignInResponse
			{
				Account = account,
				Error = error
			};
		}

		public static SignUpResponse Map(SignUpResult result)
		{
			AccountResponse account = null;
			string error = null;

			switch (result.error)
			{
				case SignUpResult.Error.ALREADY_EXISTS:
					error = "0";
					break;
				case SignUpResult.Error.INCORRECT_DATA:
					error = "1";
					break;
				case SignUpResult.Error.UNDEFINED:
					account = Map(result.user);
					break;
			}

			return new SignUpResponse
			{
				Account = account,
				Error = error
			};
		}

		public static DeleteResponse Map(DeleteResult result)
		{
			string error = null;

			switch (result.error)
			{
				case DeleteResult.Error.NOT_EXISTS:
					error = "0";
					break;
				case DeleteResult.Error.UNDEFINED:
					break;
			}

			return new DeleteResponse
			{
				Error = error
			};
		}

		private static AccountResponse Map(UserEntity account)
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
