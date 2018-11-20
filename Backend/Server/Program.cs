using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;

public class Program
{
	public static void Main(string[] args)
	{
		var config = new ConfigurationBuilder()
			.AddJsonFile("config.json", optional: false)
			.Build();

		WebHost.CreateDefaultBuilder(args)
			.UseKestrel()
			.UseStartup<Startup>()
			.UseConfiguration(config)
			.Build()
			.Run();
	}
}
