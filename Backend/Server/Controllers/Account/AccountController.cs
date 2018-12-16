using Dreamland.Controllers.Account.Mapper;
using Dreamland.UseCase.Account;
using Microsoft.AspNetCore.Mvc;

namespace Dreamland.Controllers.Account
{
	[Route("account")]
	public class AccountController : Controller
	{
		private SignInUseCase _signInUseCase;
		private SignUpUseCase _signUpUseCase;
		private DeleteAccountUseCase _deleteAccountUseCase;

		public AccountController(
			SignInUseCase signInUseCase,
			SignUpUseCase signUpUseCase,
			DeleteAccountUseCase deleteAccountUseCase)
		{
			_signInUseCase = signInUseCase;
			_signUpUseCase = signUpUseCase;
			_deleteAccountUseCase = deleteAccountUseCase;
		}

		[HttpGet("sign_in")]
		public IActionResult SignIn(
			string email,
			string password)
		{
			var serviceResult = _signInUseCase.Execute(email, password);
			var response = AccountMapper.Map(serviceResult);

			return new JsonResult(response);
		}

		[HttpGet]
		[Route("sign_up")]
		public IActionResult SignUp(
			string email,
			string password,
			[FromQuery(Name = "name")] string name)
		{
			var serviceResult = _signUpUseCase.Execute(email, password, name);
			var response = AccountMapper.Map(serviceResult);

			return new JsonResult(response);
		}

		[HttpDelete]
		[Route("delete")]
		public IActionResult Delete(
			[FromHeader(Name = AuthProperties.HEADER_AUTH_ID)] string userId,
			[FromHeader(Name = AuthProperties.HEADER_AUTH_PASSOWRD)] string userPassword)
		{
			var serviceResult = _deleteAccountUseCase.Execute(userId, userPassword);
			var response = AccountMapper.Map(serviceResult);

			return new JsonResult(response);
		}
	}
}