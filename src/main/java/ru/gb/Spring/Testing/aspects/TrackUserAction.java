package ru.gb.Spring.Testing.aspects;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface TrackUserAction {
}