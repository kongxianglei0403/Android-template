package other.mvp.fragment

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import other.mvp.first2up

/**
 *@Description
 *@author          阿土
 *@create          2023-02-07 13:20
 */
val mvpFragmentTemplate
    get() = template {

        name = "MVP Fragment"
        description = "适用于MVP框架的fragment"
        minApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        lateinit var layoutName: StringParameter

        val fragmentClass = stringParameter {
            name = "Fragment Name"
            default = "Main"
            help = "只输入名字，不要包含Fragment"
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "fragment_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { fragmentToLayout(fragmentClass.value.lowercase()) }
        }

        val packageName = defaultPackageNameParameter

        widgets(
                TextFieldWidget(fragmentClass),
                TextFieldWidget(layoutName),
                PackageNameWidget(packageName)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mvpFragmentRecipe(
                    data as ModuleTemplateData,
                    fragmentClass.value.first2up(),
                    layoutName.value,
                    packageName.value)
        }
}


val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }