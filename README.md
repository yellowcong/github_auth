##GITHUB����Ȩ����

1���û����github��¼����Ӧ�������û���ת����������Ȩҳ����Ͳ������� ��ת��ַΪ��

https://github.com/login/oauth/authorize?client_id=xxxxx&state=xxx&redirect_uri=xxxx

    ����˵��  :client_id  �Ͳ�˵��ɶ�˰�   redirect_uri����������ո������   state:����ַ�������Ȩ�ɹ���ԭ�����أ�

2 ����Ȩ�ɹ����ص�����ƽ̨����Ӧ��Ϣ�л��code���������������˹��������Ǵ������code�ٴη���github ��ַ��

https://github.com/login/oauth/access_token?client_id=xxxx&client_secret=xxx&code=xxx&redirect_uri=xxxx

�����������ˣ���λ�õ���Ӧ��access_token

3���ɹ���ȡaccess_token������������ȥ��ȡ�û���Ϣ ��ַ��

https://api.github.com/user?access_token=xxx

֮�����Ǿ��ܵõ��û���Ϣ�ˣ��������Ϳ�����������������

<img src="http://7rf288.com1.z0.glb.clouddn.com/github/github.png"/>