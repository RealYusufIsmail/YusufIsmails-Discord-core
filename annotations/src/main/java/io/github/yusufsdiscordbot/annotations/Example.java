package io.github.yusufsdiscordbot.annotations;

import java.lang.annotation.*;

/**
 * Informs the dev that this class is an example
 *
 * @since 1.0.7
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.TYPE})
public @interface Example {
}
