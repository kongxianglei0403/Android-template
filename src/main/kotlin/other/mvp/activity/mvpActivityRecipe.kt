package other.mvp.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import other.mvp.activity.res.layout.mvpActivityXml
import other.mvp.activity.src.app_package.mvpActivityKt
import other.mvp.activity.src.app_package.mvpContract
import other.mvp.activity.src.app_package.mvpModel
import other.mvp.activity.src.app_package.mvpPresenter


fun RecipeExecutor.mvpActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    generateManifest(
            moduleData = moduleData,
            activityClass = "${activityClass}Activity",
            packageName = packageName,
            isLauncher = false,
            hasNoActionBar = false,
            generateActivityTitle = true,
    )

    val mvpActivity = mvpActivityKt(projectData.applicationPackage, activityClass, layoutName, packageName)
    // 保存Activity
    save(mvpActivity, srcOut.resolve("mvp/activity/${activityClass}Activity.${ktOrJavaExt}"))
    // 保存contract
    save(mvpContract(packageName,activityClass),srcOut.resolve("mvp/contract/M${activityClass}.${ktOrJavaExt}"))
    // 保存model
    save(mvpModel(packageName, activityClass), srcOut.resolve("mvp/model/M${activityClass}Impl.${ktOrJavaExt}"))
    //保存presenter
    save(mvpPresenter(packageName, activityClass), srcOut.resolve("mvp/presenter/P${activityClass}Impl.${ktOrJavaExt}"))
    // 保存xml
    save(mvpActivityXml(activityClass), resOut.resolve("layout/${layoutName}.xml"))

}
