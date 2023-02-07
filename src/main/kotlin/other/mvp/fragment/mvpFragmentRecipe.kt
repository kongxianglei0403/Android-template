package other.mvp.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.mvp.activity.res.layout.mvpActivityXml
import other.mvp.activity.src.app_package.mvpContract
import other.mvp.activity.src.app_package.mvpModel
import other.mvp.activity.src.app_package.mvpPresenter
import other.mvp.first2up
import other.mvp.fragment.src.app_package.mvpFragmentKt

/**
 *@Description
 *@author          阿土
 *@create          2023-02-07 13:24
 */
fun RecipeExecutor.mvpFragmentRecipe(
        moduleData: ModuleTemplateData,
        fragmentClass: String,
        layoutName: String,
        packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    val mvpFragment = mvpFragmentKt(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    // 保存Activity
    save(mvpFragment, srcOut.resolve("mvp/fragment/${fragmentClass}Fragment.${ktOrJavaExt}"))
    // 保存contract
    save(mvpContract(packageName,fragmentClass),srcOut.resolve("mvp/contract/M${fragmentClass}.${ktOrJavaExt}"))
    // 保存model
    save(mvpModel(packageName, fragmentClass), srcOut.resolve("mvp/model/M${fragmentClass}Impl.${ktOrJavaExt}"))
    //保存presenter
    save(mvpPresenter(packageName, fragmentClass), srcOut.resolve("mvp/presenter/P${fragmentClass}Impl.${ktOrJavaExt}"))
    // 保存xml
    save(mvpActivityXml(fragmentClass), resOut.resolve("layout/${layoutName}.xml"))
}

