package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.select_menu;

import io.github.yusufsdiscordbot.yusufsdiscordcore.bot.YusufComponent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public record YusufSelectionMenu(SelectionMenu selectionMenu) {

    @Contract(" -> new")
    public @NotNull YusufComponent getComponent() {
        return new YusufComponent(selectionMenu());
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
        return selectionMenu.equals(obj);
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
        return selectionMenu.hashCode();
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
        return selectionMenu.toString();
    }

    /**
     * Placeholder which is displayed when no selections have been made yet.
     *
     * @return The placeholder or null
     */
    @Nullable
    public String getPlaceholder() {
        return selectionMenu.getPlaceholder();
    }

    /**
     * The minimum amount of values a user has to select.
     *
     * @return The min values
     */
    public int getMinValues() {
        return selectionMenu.getMinValues();
    }

    /**
     * The maximum amount of values a user can select at once.
     *
     * @return The max values
     */
    public int getMaxValues() {
        return selectionMenu.getMaxValues();
    }

    /**
     * The amount of values a user has selected.
     * 
     * @return The {@link SelectOption SelectOptions} this menu provides
     * @see SelectionMenu.Builder#getOptions()
     */
    @NotNull
    public List<SelectOption> getOptions() {
        return selectionMenu.getOptions();
    }

    /**
     * Whether this menu is disabled. <br>
     * You can quickly get a disabled menu from an existing menu with {@link #asDisabled()}.
     *
     * @return True, if this menu is disabled
     * @see SelectionMenu.Builder#setDisabled(boolean)
     */
    public boolean isDisabled() {
        return selectionMenu.isDisabled();
    }

    /**
     * Creates a copy of this menu with {@link #isDisabled()} set to true.
     *
     * @return A new disabled SelectionMenu instance
     * @see #withDisabled(boolean)
     */
    @NotNull
    public SelectionMenu asDisabled() {
        return selectionMenu.asDisabled();
    }

    /**
     * Creates a copy of this menu with {@link #isDisabled()} set to false.
     *
     * @return A new enabled SelectionMenu instance
     * @see #withDisabled(boolean)
     */
    @NotNull
    public SelectionMenu asEnabled() {
        return selectionMenu.asEnabled();
    }

    /**
     * Creates a copy of this menu with {@link #isDisabled()} set to the desired value.
     *
     * @param disabled Whether the menu should be disabled
     * @return A new SelectionMenu instance with {@link #isDisabled()} set to the desired value
     * @see #withDisabled(boolean)
     */
    @NotNull
    public SelectionMenu withDisabled(boolean disabled) {
        return selectionMenu.withDisabled(disabled);
    }

    /**
     * Creates a new preconfigured {@link SelectionMenu.Builder} with the same settings used for
     * this selection menu. <br>
     * This can be useful to create an updated version of this menu without needing to rebuild it
     * from scratch.
     *
     * @return The {@link SelectionMenu.Builder} used to create the selection menu
     */
    @NotNull
    public SelectionMenu.Builder createCopy() {
        return selectionMenu.createCopy();
    }

    /**
     * The type of component.
     *
     * @return {@link Component.Type}
     */
    @NotNull
    public Component.Type getType() {
        return getComponent().getType();
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
    public String getSelectionMenuId() {
        return getComponent().getComponentId();
    }

    /**
     * How many of these components can be added to one {@link ActionRow}.
     *
     * @return The maximum amount an action row can contain
     */
    public int getMaxPerRow() {
        return getComponent().getMaxPerRow();
    }

    /**
     * Serialized {@link DataObject} for this object.
     *
     * @return {@link DataObject}
     */
    @NotNull
    public DataObject toData() {
        return selectionMenu.toData();
    }
}
