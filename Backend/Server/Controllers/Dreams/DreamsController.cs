using System;
using Dreamland.Controllers.Dreams.Mapper;
using Dreamland.Domain;
using Dreamland.UseCase.Dreams;
using Microsoft.AspNetCore.Mvc;

namespace Dreamland.Controllers.Dreams
{
	[Route("dreams")]
	public class DreamsController : Controller
	{
		private FetchUseCase _fetchUseCase;
		private SaveUseCase _saveUseCase;
		private EditUseCase _editUseCase;
		private DeleteDreamUseCase _deleteUseCase;

		public DreamsController(
			DeleteDreamUseCase deleteUseCase,
			FetchUseCase fetchUseCase,
			SaveUseCase saveUseCase,
			EditUseCase editUseCase)
		{
			_deleteUseCase = deleteUseCase;
			_fetchUseCase = fetchUseCase;
			_saveUseCase = saveUseCase;
			_editUseCase = editUseCase;
		}

		[HttpGet("fetch")]
		public IActionResult Fetch(
			[FromHeader(Name = AuthProperties.HEADER_AUTH_ID)] string userId,
			[FromHeader(Name = AuthProperties.HEADER_AUTH_PASSOWRD)] string userPassword)
		{
			var result = _fetchUseCase.Execute(userId, userPassword);
			var response = DreamsMapper.Map(result);

			return new JsonResult(response);
		}

		[HttpPost("save")]
		public IActionResult Save(
			[FromHeader(Name = AuthProperties.HEADER_AUTH_ID)] string userId,
			[FromHeader(Name = AuthProperties.HEADER_AUTH_PASSOWRD)] string userPassword,
			[FromBody] DreamProperties properties)
		{
			var result = _saveUseCase.Execute(userId, userPassword, properties);
			var response = DreamsMapper.Map(result);

			return new JsonResult(response);
		}

		[HttpPost("edit")]
		public IActionResult Fetch(
			[FromHeader(Name = AuthProperties.HEADER_AUTH_ID)] string userId,
			[FromHeader(Name = AuthProperties.HEADER_AUTH_PASSOWRD)] string userPassword,
			[FromBody] DreamProperties properties)
		{
			var result = _editUseCase.Execute(userId, userPassword, properties);
			var response = DreamsMapper.Map(result);

			return new JsonResult(response);
		}

		[HttpDelete("delete")]
		public IActionResult Fetch(
			[FromHeader(Name = AuthProperties.HEADER_AUTH_ID)] string userId,
			[FromHeader(Name = AuthProperties.HEADER_AUTH_PASSOWRD)] string userPassword,
			[FromQuery(Name = "dreamId")] int dreamId)
		{
			var result = _deleteUseCase.Execute(userId, userPassword, dreamId);
			var response = DreamsMapper.Map(result);

			return new JsonResult(response);
		}
	}
}