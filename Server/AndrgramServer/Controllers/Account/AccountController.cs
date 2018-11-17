using Microsoft.AspNetCore.Mvc;

namespace Dreamland.Controllers.Account
{
	[Route("account")]
    public class AccountController : Controller
    {
		[HttpGet("sign_in")]
        public IActionResult SignIn(
			string email,
			string password)
        {
			var result = new SignInResponseJson
			{
				Account = new AccountResponseJson
				{
					Id = 0,
					FullName = "Ivan Andreyshev",
					AvatarUrl = "images/avatar.jpg"
				},
				Error = "0"
			};

			return Json(result);
        }

		[HttpGet]
		[Route("sign_up")]
		public IActionResult SignUp(
			string email,
			string password,
			[FromQuery(Name = "full_name")] string fullName)
		{
			return View();
		}

		[HttpDelete]
		[Route("delete")]
		public IActionResult Delete(
			int id,
			string password)
		{
			return View();
		}
	}
}