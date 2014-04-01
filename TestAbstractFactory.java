package design.pattern;

interface Cpu{
	void process();
}
interface CpuFactory{
	Cpu produceCpu();
}
class AmdCpu implements Cpu{
	public void process() {
		System.out.println("Amd is processing");
	}
}
class InterCpu implements Cpu{
	public void process() {
		System.out.println("Inter is processing");
	}
}
class AmdFactory implements CpuFactory{
	public Cpu produceCpu() {
		return new AmdCpu();
	}
}
class IntelFactory implements CpuFactory{
	public Cpu produceCpu() {
		return new InterCpu();
	}
}
class Computer{
	Cpu cpu;
	public Computer(CpuFactory factory){
		cpu = factory.produceCpu();
		cpu.process();
	}
}
public class TestAbstractFactory {
	public static void main(String[] args) {
		new Computer(creatSpecificFactory());
	}
	public static CpuFactory creatSpecificFactory(){
		int sys = 0;
		if(sys == 0)
			return new AmdFactory();
		else
			return new IntelFactory();
	}
}
