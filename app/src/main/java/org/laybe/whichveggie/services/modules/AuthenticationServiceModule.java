package org.laybe.whichveggie.services.modules;

import org.laybe.whichveggie.modules.AppModule;
import org.laybe.whichveggie.services.AuthenticationService;

import dagger.Module;

@Module (
		injects = AuthenticationService.class,
		addsTo = AppModule.class)
public class AuthenticationServiceModule {
}
