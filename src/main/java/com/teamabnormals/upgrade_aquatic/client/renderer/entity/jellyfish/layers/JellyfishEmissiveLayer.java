package com.teamabnormals.upgrade_aquatic.client.renderer.entity.jellyfish.layers;

import com.teamabnormals.blueprint.client.BlueprintRenderTypes;
import com.teamabnormals.blueprint.core.endimator.entity.EndimatorEntityModel;
import com.teamabnormals.blueprint.core.util.MathUtil;
import com.teamabnormals.upgrade_aquatic.client.renderer.entity.jellyfish.AbstractJellyfishRenderer;
import com.teamabnormals.upgrade_aquatic.common.entity.animal.jellyfish.AbstractJellyfish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.Mth;

public class JellyfishEmissiveLayer<T extends AbstractJellyfish, M extends EndimatorEntityModel<T>> extends RenderLayer<T, M> {
	private final AbstractJellyfishRenderer<T> jellyfishRenderer;

	public JellyfishEmissiveLayer(RenderLayerParent<T, M> renderer, AbstractJellyfishRenderer<T> jellyfishRenderer) {
		super(renderer);
		this.jellyfishRenderer = jellyfishRenderer;
	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T jellyfish, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		VertexConsumer ivertexbuilder = bufferIn.getBuffer(BlueprintRenderTypes.getUnshadedTranslucentEntity(this.jellyfishRenderer.getOverlayTexture(jellyfish), true));
		this.getParentModel().setupAnim(jellyfish, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, Mth.clamp((packedLightIn + MathUtil.getBrightLightForLight(packedLightIn)) - 20, 50, 240), LivingEntityRenderer.getOverlayCoords(jellyfish, 0.0F), 1.0F, 1.0F, 1.0F, 0.7F);
	}
}