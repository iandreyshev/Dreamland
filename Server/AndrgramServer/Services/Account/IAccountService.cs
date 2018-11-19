using Dreamland.Services.Account.Model;

namespace Dreamland.Services.Account
{
	public interface IAccountService
	{
		SignInResult SignIn(string email, string password);
		SignUpResult SignUp(string email, string password, string name);
		DeleteResult Delete(int id, string password);
	}
}
