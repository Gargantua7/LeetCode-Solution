#!/bin/bash

# ====================================================
# 功能: 仅将【指定子文件夹】下的更改打包成一个提交并推送
# ====================================================

# 1. 获取并处理路径参数
SOURCE_PATH="./src"

# 获取绝对路径，防止因 cd 导致路径失效
# 使用 cd + pwd 的方式兼容性最好 (兼容 Linux 和 macOS)
TARGET_PATH=$(cd "$SOURCE_PATH" && pwd)

# 2. 找到该目录所属的 Git 根目录
# -C 参数允许在指定目录下执行 git 命令
GIT_ROOT=$(git -C "$TARGET_PATH" rev-parse --show-toplevel 2>/dev/null)

# 3. 检查目标目录下是否有变更 (仅检测该路径)
# git status 传入路径参数，只检测该路径下的变动
if [ -z "$(git -C "$GIT_ROOT" status "$TARGET_PATH" --porcelain)" ]; then
    echo "✅ 目标目录下没有检测到更改，无需操作。"
    exit 0
fi

# 4. 切换到 Git 根目录执行操作 (最稳妥的方式)
cd "$GIT_ROOT" || exit

# 5. 获取日期
COMMIT_MSG=$(date "+%Y/%m/%d")

# 6. 精确添加与提交
echo "➕ 正在添加目标目录下的更改..."
git add "$TARGET_PATH"

echo "💾 正在提交 (仅限目标目录)..."
# 注意: -- "$TARGET_PATH" 语法强制 git 只提交该路径下的文件
# 即使你在仓库其他地方有 add 过的文件，这里也不会提交它们
git commit -m "$COMMIT_MSG" -- "$TARGET_PATH"

if [ $? -ne 0 ]; then
    echo "❌ 提交失败 (可能是没有文件需要提交，或者路径被 .gitignore 忽略)。"
    exit 1
fi

# 7. 推送
echo "🚀 正在推送到远程仓库..."
git push

if [ $? -eq 0 ]; then
    echo "✅ 成功！已将 '$TARGET_PATH' 的更改同步到远程。"
else
    echo "❌ 推送失败"
fi