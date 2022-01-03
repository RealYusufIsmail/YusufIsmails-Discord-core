package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.button;

import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Button;
import net.dv8tion.jda.api.interactions.components.ButtonStyle;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public record YusufButton(Button button) {
    public Button getButton() {
        return button;
    }


    /**
     * Indicates whether some other object is "equal to" this one. In addition to the general
     * contract of {@link Object#equals(Object) Object.equals}, record classes must further obey the
     * invariant that when a record instance is "copied" by passing the result of the record
     * component accessor methods to the canonical constructor, as follows:
     * 
     * <pre>
     *     R copy = new R(r.c1(), r.c2(), ..., r.cn());
     * </pre>
     * 
     * then it must be the case that {@code r.equals(copy)}.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this record is equal to the argument; {@code false} otherwise.
     * @implSpec The implicitly provided implementation returns {@code true} if and only if the
     *           argument is an instance of the same record class as this record, and each component
     *           of this record is equal to the corresponding component of the argument; otherwise,
     *           {@code
     * false} is returned. Equality of a component {@code c} is determined as follows:
     *           <ul>
     *
     *           <li>If the component is of a reference type, the component is considered equal if
     *           and only if {@link Objects#equals(Object, Object) Objects.equals(this.c, r.c} would
     *           return {@code true}.
     *
     *           <li>If the component is of a primitive type, using the corresponding primitive
     *           wrapper class {@code PW} (the corresponding wrapper class for {@code int} is {@code
     * java.lang.Integer}, and so on), the component is considered equal if and only if {@code
     * PW.compare(this.c, r.c)} would return {@code 0}.
     *
     *           </ul>
     *           <p>
     *           Apart from the semantics described above, the precise algorithm used in the
     *           implicitly provided implementation is unspecified and is subject to change. The
     *           implementation may or may not use calls to the particular methods listed, and may
     *           or may not perform comparisons in the order of component declaration.
     * @see Objects#equals(Object, Object)
     */
    public boolean equals(Object obj) {
        return button.equals(obj);
    }

    /**
     * Returns a hash code value for the record. Obeys the general contract of
     * {@link Object#hashCode Object.hashCode}. For records, hashing behavior is constrained by the
     * refined contract of {@link Record#equals Record.equals}, so that any two records created from
     * the same components must have the same hash code.
     *
     * @return a hash code value for this record.
     * @implSpec The implicitly provided implementation returns a hash code value derived by
     *           combining appropriate hashes from each component. The precise algorithm used in the
     *           implicitly provided implementation is unspecified and is subject to change within
     *           the above limits. The resulting integer need not remain consistent from one
     *           execution of an application to another execution of the same application, even if
     *           the hashes of the component values were to remain consistent in this way. Also, a
     *           component of primitive type may contribute its bits to the hash code differently
     *           than the {@code hashCode} of its primitive wrapper class.
     * @see Object#hashCode()
     */
    public int hashCode() {
        return button.hashCode();
    }

    /**
     * Returns a string representation of the record. In accordance with the general contract of
     * {@link Object#toString()}, the {@code toString} method returns a string that "textually
     * represents" this record. The result should be a concise but informative representation that
     * is easy for a person to read.
     * <p>
     * In addition to this general contract, record classes must further participate in the
     * invariant that any two records which are {@linkplain Record#equals(Object) equal} must
     * produce equal strings. This invariant is necessarily relaxed in the rare case where
     * corresponding equal component values might fail to produce equal strings for themselves.
     *
     * @return a string representation of the object.
     * @implSpec The implicitly provided implementation returns a string which contains the name of
     *           the record class, the names of components of the record, and string representations
     *           of component values, so as to fulfill the contract of this method. The precise
     *           format produced by this implicitly provided implementation is subject to change, so
     *           the present syntax should not be parsed by applications to recover record component
     *           values.
     * @see Object#toString()
     */
    public String toString() {
        return button.toString();
    }

    /**
     * The visible text on the button.
     *
     * @return The button label
     */
    @NotNull
    public String getLabel() {
        return button.getLabel();
    }

    /**
     * The style of this button.
     *
     * @return {@link ButtonStyle}
     */
    @NotNull
    public ButtonStyle getStyle() {
        return button.getStyle();
    }

    /**
     * The target URL for this button, if it is a {@link ButtonStyle#LINK LINK}-Style Button.
     *
     * @return The target URL or null
     */
    @Nullable
    public String getUrl() {
        return button.getUrl();
    }

    /**
     * The emoji attached to this button. <br>
     * This can be either {@link Emoji#isUnicode() unicode} or {@link Emoji#isCustom()} custom.
     *
     * <p>
     * You can use {@link #withEmoji(Emoji)} to create a button with an Emoji.
     *
     * @return {@link Emoji} for this button
     */
    @Nullable
    public Emoji getEmoji() {
        return button.getEmoji();
    }

    /**
     * Whether this button is disabled.
     *
     * <p>
     * You can use {@link #asDisabled()} or {@link #asEnabled()} to create enabled/disabled
     * instances.
     *
     * @return True, if this button is disabled
     */
    public boolean isDisabled() {
        return button.isDisabled();
    }

    /**
     * Returns a copy of this button with {@link #isDisabled()} set to true.
     *
     * @return New disabled button instance
     */
    @NotNull
    public Button asDisabled() {
        return button.asDisabled();
    }

    /**
     * Returns a copy of this button with {@link #isDisabled()} set to false.
     *
     * @return New enabled button instance
     */
    @NotNull
    public Button asEnabled() {
        return button.asEnabled();
    }

    /**
     * Returns a copy of this button with {@link #isDisabled()} set to the provided value.
     *
     * @param disabled True, if this button should be disabled
     * @return New enabled/disabled button instance
     */
    @NotNull
    public Button withDisabled(boolean disabled) {
        return button.withDisabled(disabled);
    }

    /**
     * Returns a copy of this button with the attached Emoji.
     *
     * @param emoji The emoji to use
     * @return New button with emoji
     */
    @NotNull
    public Button withEmoji(@Nullable Emoji emoji) {
        return button.withEmoji(emoji);
    }

    /**
     * Returns a copy of this button with the provided label.
     *
     * @param label The label to use
     * @return New button with the changed label
     *
     */
    @NotNull
    public Button withLabel(@NotNull String label) {
        return button.withLabel(label);
    }

    /**
     * Returns a copy of this button with the provided id.
     *
     * @param id The id to use
     * @return New button with the changed id
     *
     */
    @NotNull
    public Button withId(@NotNull String id) {
        return button.withUrl(id);
    }

    /**
     * Returns a copy of this button with the provided url.
     *
     * @param url The url to use
     * @return New button with the changed url
     */
    @NotNull
    public Button withUrl(@NotNull String url) {
        return button.withUrl(url);
    }

    /**
     * Returns a copy of this button with the provided style.
     *
     * <p>
     * You cannot use this convert link buttons.
     *
     * @param style The style to use
     * @return New button with the changed style
     * @throws IllegalArgumentException
     *         <ul>
     *         <li>If the provided {@code style} is null.</li>
     *         <li>If the provided {@code style} tries to change whether this button is a
     *         {@link ButtonStyle#LINK LINK} button.</li>
     *         </ul>
     */
    @NotNull
    public Button withStyle(@NotNull ButtonStyle style) {
        return button.withStyle(style);
    }

    /**
     * The type of component.
     *
     * @return {@link Component.Type}
     */
    public Component.@NotNull Type getType() {
        return button.getType();
    }

    /**
     * The component ID or null. <br>
     * Some components such as link buttons don't have this.
     *
     * <p>
     * This need not be a numeric ID! All these component IDs are custom and not generated by
     * Discord.
     *
     * @return The component ID or null if not present
     */
    @Nullable
    public String getButtonId() {
        return button.getId();
    }

    /**
     * How many of these components can be added to one {@link ActionRow}.
     *
     * @return The maximum amount an action row can contain
     */
    public int getMaxPerRow() {
        return button.getMaxPerRow();
    }

    /**
     * Serialized {@link DataObject} for this object.
     *
     * @return {@link DataObject}
     */
    @NotNull
    public DataObject toData() {
        return button.toData();
    }
}
