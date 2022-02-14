package io.github.yusufsdiscordbot.config;

import io.github.yusufsdiscordbot.annotations.Author;

/**
 * Shows the amount of times this class has been changed
 */
@Author(firstName = "Yusuf", lastName = "Arfan Ismail", githubUserName = "RealYusufIsmail")
public interface ClassVersion {
    /**
     * The version of the class
     * 
     * @return the true version of that class
     *
     * @since 1.0.0
     */
    int version();
}
