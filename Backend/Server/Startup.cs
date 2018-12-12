﻿using Dreamland.Storage;
using Dreamland.Storage.Account;
using Dreamland.UseCase.Account;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

public class Startup
{
	public Startup(IConfiguration configuration)
	{
		Configuration = configuration;
	}

	public IConfiguration Configuration { get; }

	// This method gets called by the runtime. Use this method to add services to the container.
	public void ConfigureServices(IServiceCollection services)
	{
		services.AddMvc();

		// UseCase`s
		services.AddTransient<SignInUseCase>();
		services.AddTransient<SignUpUseCase>();
		services.AddTransient<DeleteAccountUseCase>();

		// Storage
		services.AddDbContext<DatabaseContext>();
		services.AddTransient<IAccountStorage, AccountStorage>();
	}

	// This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
	public void Configure(IApplicationBuilder app, IHostingEnvironment env)
	{
		if (env.IsDevelopment())
		{
			app.UseDeveloperExceptionPage();
		}

		app.UseStaticFiles();
		app.UseMvc();
	}
}