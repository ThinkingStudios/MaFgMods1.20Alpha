package fi.dy.masa.malilib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.MinecraftClient;

import net.minecraftforge.client.gui.overlay.ForgeGui;
import fi.dy.masa.malilib.event.RenderEventHandler;

@Mixin(ForgeGui.class)
public abstract class MixinInGameHud {
    @Inject(method = "render", at = @At("RETURN"))
    private void onGameOverlayPost(DrawContext drawContext, float partialTicks, CallbackInfo ci) {
        ((RenderEventHandler) RenderEventHandler.getInstance()).onRenderGameOverlayPost(drawContext, MinecraftClient.getInstance(), partialTicks);
    }
}
