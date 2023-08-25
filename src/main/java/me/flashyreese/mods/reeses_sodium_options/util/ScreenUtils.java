package me.flashyreese.mods.reeses_sodium_options.util;

import net.minecraft.client.gui.DrawContext;

public class ScreenUtils {
    public static void drawRect(DrawContext drawContext, int x1, int y1, int x2, int y2, int color) {
        drawContext.fill(x1, y1, x2, y2, color);
    }

    public static void drawBorder(DrawContext drawContext, int x1, int y1, int x2, int y2, int color) {
        drawContext.fill(x1, y1, x2, y1 + 1, color);
        drawContext.fill(x1, y2 - 1, x2, y2, color);
        drawContext.fill(x1, y1, x1 + 1, y2, color);
        drawContext.fill(x2 - 1, y1, x2, y2, color);
    }
}
