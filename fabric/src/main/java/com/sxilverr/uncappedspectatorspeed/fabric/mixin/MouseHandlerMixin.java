package com.sxilverr.uncappedspectatorspeed.fabric.mixin;

import com.sxilverr.uncappedspectatorspeed.SpectatorSpeed;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin
{
    @Inject(method = "onScroll", at = @At("HEAD"), cancellable = true)
    private void uncappedspectatorspeed$onScroll(long windowPointer, double xOffset, double yOffset, CallbackInfo ci)
    {
        if (SpectatorSpeed.applyScroll(yOffset))
        {
            ci.cancel();
        }
    }
}
