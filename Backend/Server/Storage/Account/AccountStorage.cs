using Dreamland.Domain;
using Microsoft.EntityFrameworkCore;
using System;
using System.Linq;

namespace Dreamland.Storage.Account
{
	public class AccountStorage : Storage, IAccountStorage
	{
		private DbSet<User> _users;

		public AccountStorage(DatabaseContext context) : base(context)
		{
			_users = Context.Users;
		}

		public User Find(long userId, string password)
		{
			var users = _users.Where(u => u.Id == userId && u.Password == password);

			if (users.Count() == 0)
			{
				return null;
			}

			return users.First();
		}

		public User Find(string email, string password)
		{
			var users = _users.Where(u => u.Email == email && u.Password == password);

			if (users.Count() == 0)
			{
				return null;
			}

			return users.First();
		}

		public void Add(User user)
		{
			_users.Add(user);
			Context.SaveChanges();
		}

		public void Delete(long id)
		{
			var user = new User { Id = id };
			_users.Attach(user);
			_users.Remove(user);
			Context.SaveChanges();
		}

		public bool UserExists(long id)
		{
			return _users.Where(u => u.Id == id).Count() > 0;
		}
	}
}
