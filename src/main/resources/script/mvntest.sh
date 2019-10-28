# ?/bin/sh
pwd

cd ../myTestCase
echo "打印环境变量"
echo "$MY_NAME"
export MY_NAME=geekluxun123
echo "设置环境变量"
echo "$MY_NAME"
export PATH=${PATH}:/luxun222
mvn clean test -X

echo "我结束啦"

