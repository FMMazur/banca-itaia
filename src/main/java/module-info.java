module br.ufms.bancas {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.remixicon;
    requires org.kordamp.ikonli.fontawesome5;

    requires jakarta.persistence;
    requires jakarta.inject;
    requires jakarta.transaction;
    requires jakarta.xml.bind;

    requires com.fasterxml.classmate;
    requires com.fasterxml.jackson.core;

    requires org.jboss.logging;
    requires org.hsqldb;
    requires org.hibernate.validator;
    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;

    requires com.esotericsoftware.kryo;

    requires static lombok;
    requires java.naming;
    requires com.google.guice;
    requires fr.brouillard.oss.cssfx;
    requires MaterialFX;
    requires com.google.common;

    exports br.ufms.bancas;
    exports br.ufms.bancas.model;

    opens br.ufms.bancas to com.esotericsoftware.kryo, com.google.guice, javafx.fxml;
    opens br.ufms.bancas.controller to com.esotericsoftware.kryo, com.google.guice, javafx.fxml;
    opens br.ufms.bancas.dao to com.esotericsoftware.kryo, com.google.guice, javafx.fxml;
    opens br.ufms.bancas.dao.hsqldb to com.esotericsoftware.kryo, com.google.guice, javafx.fxml;
    opens br.ufms.bancas.dao.memory to com.esotericsoftware.kryo, com.google.guice, javafx.fxml;
    opens br.ufms.bancas.di to com.esotericsoftware.kryo, com.google.guice, javafx.fxml;
    opens br.ufms.bancas.model to com.esotericsoftware.kryo, com.google.guice, javafx.fxml;
    opens br.ufms.bancas.scene to com.esotericsoftware.kryo, com.google.guice, javafx.fxml;
    opens br.ufms.bancas.service to com.esotericsoftware.kryo, com.google.guice, javafx.fxml;
    opens br.ufms.bancas.utils to com.esotericsoftware.kryo, com.google.guice, javafx.fxml;
    opens br.ufms.bancas.view to com.esotericsoftware.kryo, com.google.guice, javafx.fxml;
}