package br.ufms.bancas.di;

import br.ufms.bancas.controller.*;
import com.google.inject.AbstractModule;

public class ControllerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(LoginController.class);
        bind(HomeController.class);
        bind(DashboardController.class);
        bind(MenuOptionsController.class);
        bind(ClientController.class);
        bind(EstoqueController.class);
        bind(CadastroEstoqueController.class);
    }
}
