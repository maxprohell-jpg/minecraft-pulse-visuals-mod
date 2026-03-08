import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static final KeyBinding KEY_PLUS = new KeyBinding("key.plus", GLFW.GLFW_KEY_EQUAL, "key.categories.gameplay");
    public static final KeyBinding KEY_MINUS = new KeyBinding("key.minus", GLFW.GLFW_KEY_MINUS, "key.categories.gameplay");

    public static void register() {
        // Register the key bindings with the Minecraft key binding manager
        KeyBindingHelper.registerKeyBinding(KEY_PLUS);
        KeyBindingHelper.registerKeyBinding(KEY_MINUS);
    }
}