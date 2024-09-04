package com.ultricem.exoterra.datagen;

import com.ultricem.exoterra.ExoTerra;
import com.ultricem.exoterra.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        // NOTE: Ingot > nugget and back again recipes in block below.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.IRIDIUM_NUGGET.get(), 9).requires(ModItems.IRIDIUM_INGOT.get()).unlockedBy("has_iridium_ingot", has(ModItems.IRIDIUM_INGOT.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALUMINUM_NUGGET.get(), 9).requires(ModItems.ALUMINUM_INGOT.get()).unlockedBy("has_aluminum_ingot", has(ModItems.ALUMINUM_INGOT.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN_NUGGET.get(), 9).requires(ModItems.TIN_INGOT.get()).unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM_NUGGET.get(), 9).requires(ModItems.TITANIUM_INGOT.get()).unlockedBy("has_titanium_ingot", has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_NUGGET.get(), 9).requires(ModItems.STEEL_INGOT.get()).unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRIDIUM_INGOT.get()).pattern("NNN").pattern("NNN").pattern("NNN").define('N', ModItems.IRIDIUM_NUGGET.get()).unlockedBy("has_iridium_nugget", has(ModItems.IRIDIUM_NUGGET.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get()).pattern("NNN").pattern("NNN").pattern("NNN").define('N', ModItems.ALUMINUM_NUGGET.get()).unlockedBy("has_aluminum_nugget", has(ModItems.ALUMINUM_NUGGET.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TIN_INGOT.get()).pattern("NNN").pattern("NNN").pattern("NNN").define('N', ModItems.TIN_NUGGET.get()).unlockedBy("has_tin_nugget", has(ModItems.TIN_NUGGET.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get()).pattern("NNN").pattern("NNN").pattern("NNN").define('N', ModItems.TITANIUM_NUGGET.get()).unlockedBy("has_titanium_nugget", has(ModItems.TITANIUM_NUGGET.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STEEL_INGOT.get()).pattern("NNN").pattern("NNN").pattern("NNN").define('N', ModItems.STEEL_NUGGET.get()).unlockedBy("has_steel_nugget", has(ModItems.STEEL_NUGGET.get())).save(pRecipeOutput);
        // NOTE: Block end

    }






    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, ExoTerra.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
