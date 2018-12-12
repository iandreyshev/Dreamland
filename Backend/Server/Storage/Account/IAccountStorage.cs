using Dreamland.Domain;
using System;

namespace Dreamland.Storage.Account
{
	public interface IAccountStorage
	{
		TResult Transaction<TResult>(TResult errVal, Func<int, TResult> body);
		void Add(User user);
		User Find(string email, string password);
		void Delete(long user);
	}
}
