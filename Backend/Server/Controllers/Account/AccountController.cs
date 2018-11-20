using Dreamland.Controllers.Account.Mapper;
using Dreamland.Services.Account;
using Microsoft.AspNetCore.Mvc;

namespace Dreamland.Controllers.Account
{
	[Route("account")]
	public class AccountController : Controller
	{
		private readonly IAccountService _service;

		public AccountController(IAccountService service)
		{
			_service = service;
		}

		[HttpGet("sign_in")]
		public IActionResult SignIn(
			string email,
			string password)
		{
			var serviceResult = _service.SignIn(email, password);
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
			var serviceResult = _service.SignUp(email, password, name);
			var response = AccountMapper.Map(serviceResult);

			return new JsonResult(response);
		}

		[HttpDelete]
		[Route("delete")]
		public IActionResult Delete(
			int id,
			string password)
		{
			var serviceResult = _service.Delete(id, password);
			var response = AccountMapper.Map(serviceResult);

			return new JsonResult(response);
		}
	}
}