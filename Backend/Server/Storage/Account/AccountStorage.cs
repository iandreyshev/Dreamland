using Dreamland.Domain;
using Microsoft.EntityFrameworkCore;
using System;
using System.Linq;

namespace Dreamland.Storage.Account
{
	public class AccountStorage : IAccountStorage
	{
		public AccountStorage(DatabaseContext context)
		{
			_context = context;
			_users = _context.Users;
		}

		private DatabaseContext _context;
		private DbSet<User> _users;

		public User Find(string email, string password)
		{
			return _users.Where(u => u.Email == email && u.Password == password)
				.First();
		}

		public void Add(User user)
		{
			_users.Add(user);
			_context.SaveChanges();
		}

		public void Delete(long id)
		{
			var user = new User { Id = id };
			_users.Attach(user);
			_users.Remove(user);
			_context.SaveChanges();
		}

		public TResult Transaction<TResult>(TResult errVal, Func<int, TResult> body)
			=> _context.Transaction(errVal, body);
	}
}
