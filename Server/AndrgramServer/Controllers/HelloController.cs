using Microsoft.AspNetCore.Mvc;

namespace AndrgramServer.Controllers
{
	[Route("api/Index")]
	public class IndexController : Controller
	{
		// POST api/Index
		[HttpGet]
		public string Get([FromForm]string text)
		{
			return "Hello, world!";
		}
	}
}
