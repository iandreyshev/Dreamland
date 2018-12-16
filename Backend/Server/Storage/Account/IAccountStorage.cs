using Dreamland.Domain;
namespace Dreamland.Storage.Account
{
	public interface IAccountStorage : IStorage
	{
		void Add(User user);
		User Find(long userId, string password);
		User Find(string email, string password);
		bool UserExists(long id);
		void Delete(long userId);
	}
}
