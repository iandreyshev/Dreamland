using Dreamland.Domain;
using System;

namespace Dreamland.Storage.Account
{
	public interface IAccountStorage : IStorage
	{
		void Add(User user);
		User Find(long userId, string password);
		User Find(string email, string password);
		void Delete(long userId);
	}
}
