using System.Collections.Generic;

namespace Dreamland.Storage.Account
{
	public class AccountStorage
	{
		private int _lastId = 0;
		private List<UserEntity> _users = new List<UserEntity>();

		public UserEntity Add(string email, string password, string name)
		{
			var userEntity = _users.Find(user =>
			{
				return user.Email == email && user.Password == password;
			});

			if (userEntity == null)
			{
				_users.Add(new UserEntity
				{
					Id = ++_lastId,
					Email = email,
					Password = password,
					Name = name,
					AvatarUrl = ""
				});

				return _users[_users.Count - 1];
			}

			return null;
		}

		public UserEntity Find(string email, string password)
		{
			return _users.Find(user =>
			{
				return user.Email == email && user.Password == password;
			});
		}

		public bool Delete(int id, string password)
		{
			var userEntity = _users.Find(user =>
			{
				return user.Id == id && user.Password == password;
			});

			return _users.Remove(userEntity);
		}
	}
}
