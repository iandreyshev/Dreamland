namespace Dreamland.Services.Account
{
	internal class Preconditions
	{
		public static bool IsValidEmail(string email) =>
			!string.IsNullOrEmpty(email)
				&& !string.IsNullOrWhiteSpace(email)
				&& email.Contains("@");

		public static bool IsValidPassword(string password) =>
			!string.IsNullOrEmpty(password)
				&& password.Length >= 6;

		public static bool IsValidName(string name) =>
			!string.IsNullOrEmpty(name)
				&& !string.IsNullOrWhiteSpace(name);
	}
}
